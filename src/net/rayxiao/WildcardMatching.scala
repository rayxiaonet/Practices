package net.rayxiao

/**
  * Created by rxiao on 7/7/16.
  */

object WildcardMatching extends App {

  val input = "aabbccdd"
  val pattern = "a*b"
  type matcher = (String, String, String) => Boolean

  def getNextMatcher(patterns: String, str: String): Boolean = {
    if (str.length == 0) {
      if (patterns.length == 0) return true
      else return false
    }
    if (patterns.length == 0) return false

    patterns.charAt(0) match {
      case '*' => asteriskMatcher("*", str, patterns.substring(1))
      case '?' => questionMatcher("?", str, patterns.substring(1))
      case _ => charMatcher(patterns.charAt(0).toString, str, patterns.substring(1))
    }
  }

  def charMatcher(pattern: String, str: String, nextPattern: String) = {
    if (pattern.equals(str.substring(0, 1)))
      getNextMatcher(nextPattern, str.substring(1))
    else false
  }

  def asteriskMatcher(pattern: String, str: String, nextPattern: String): Boolean = {
    if (nextPattern.length == 0) return true
    def iterInternal(str: String, nextPattern: String): Boolean = {
      if (str.length == 0) false
      else if (getNextMatcher(nextPattern, str)) true
      else iterInternal(str.substring(1), nextPattern)
    }

    iterInternal(str, nextPattern);


  }

  def questionMatcher(pattern: String, str: String, nextPattern: String): Boolean = {
    if (str.length > 0) getNextMatcher(nextPattern, str.substring(1))
    else false

  }


  println(getNextMatcher("?*", "ab"));


}
