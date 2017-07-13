package detection

import java.nio.ByteBuffer

import org.bytedeco.javacpp.indexer.UByteRawIndexer
import org.bytedeco.javacpp.opencv_core.{DMatchVector, Scalar, Mat, KeyPointVector, NORM_L2}
import org.bytedeco.javacpp.opencv_features2d.{BFMatcher, DrawMatchesFlags, drawKeypoints, drawMatches}
import org.bytedeco.javacpp.opencv_xfeatures2d.{SURF, SIFT}
import org.bytedeco.javacpp.opencv_imgcodecs.imread

import org.bytedeco.javacpp.opencv_calib3d._
import org.bytedeco.javacpp.opencv_core._
import org.bytedeco.javacpp.opencv_features2d._
import org.bytedeco.javacpp.opencv_imgproc._
import OpenCVUtils._

import org.bytedeco.javacv.OpenCVFrameConverter.ToMat
import org.bytedeco.javacv.CanvasFrame
import javax.swing.JFrame

import scala.math.round

/**
  * Created by steven on 15-6-17.
  */
object Main {
  def main(args: Array[String]): Unit = {

    val image1 = imread("data/EmptyAcceptgiro.png")
//    val image2 = imread("data/RotatedAcceptgiro.png")
//    val image2 = imread("data/Acceptgiro_ok2.jpg")
    val image2 = imread("data/Acceptgiro_ok6.jpg")

    // 0. Construction of the detector and descriptor
    // for example SURF
    val detector  = SURF.create()
//    val detector  = SIFT.create()
    val extractor = detector

    // 1. Detection of the feature points
    val keypoints1 = new KeyPointVector()
    val keypoints2 = new KeyPointVector()
    detector.detect(image1, keypoints1)
    detector.detect(image2, keypoints2)

    println("Number of feature points (1): " + keypoints1.size)
    println("Number of feature points (2): " + keypoints2.size)

    // 2. Extraction of the feature descriptors
    val descriptors1 = new Mat()
    val descriptors2 = new Mat()
    extractor.compute(image1, keypoints1, descriptors1)
    extractor.compute(image2, keypoints2, descriptors2)

    // 3. Match the two image descriptors

    // Construction of the matcher with crosscheck
    val matcher = new BFMatcher(NORM_L2, true)
    // matching
    val matches = new DMatchVector()
    matcher.`match`(descriptors1, descriptors2, matches)

    // Convert keypoints into Point2f
    val (points1, points2) = toPoint2fVectorPair(matches, keypoints1, keypoints2)

    println(points1.size() + " " + points2.size())

    // Find the homography between image 1 and image 2
    val inliers    = new Mat()
    val homography = findHomography(
      toMat(points1), toMat(points2), // corresponding points
      inliers, // outputted inliers matches
      RANSAC, // RANSAC method
      1.0 // max distance to reprojection point
    )

    // Draw the inlier points
    val inlinerIndexer = inliers.createIndexer().asInstanceOf[UByteRawIndexer]
    for (i <- 0 until points1.size.toInt if inlinerIndexer.get(i) != 0) {
      val p = points1.get(i)
      circle(image1, new Point(round(p.x), round(p.y)), 3, new Scalar(0, 0, 255, 0))
    }
    for (i <- 0 until points2.size.toInt if inlinerIndexer.get(i) != 0) {
      val p = points2.get(i)
      circle(image2, new Point(round(p.x), round(p.y)), 3, new Scalar(0, 0, 255, 0))
    }
    show(image1, "Image 1 Homography Points")
    show(image2, "Image 2 Homography Points")

    // draw the matches
    val imageMatches = new Mat()

    drawMatches(
      image1, keypoints1, // 1st image and its keypoints
      image2, keypoints2, // 2nd image and its keypoints
      matches, // the matches
      imageMatches, // the image produced
      Scalar.all(-1), // color of the lines
      Scalar.all(-1), // color of the keypoints
      null.asInstanceOf[ByteBuffer], // empty mask
      2
    )
    show(imageMatches, "ÄWESOME")
  }
}
