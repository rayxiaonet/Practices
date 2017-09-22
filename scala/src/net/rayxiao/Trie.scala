package net.rayxiao


import scala.collection.mutable

/**
  * Created by rxiao on 7/7/16.
  */

object Trie extends App {
  val t = new Trie()
  t.insert("ABCDE")
  t.insert("ACAD")
  t.insert("ABCD")

  println(t.search("ACAD"))
  println(t.search("ACA"))
  println(t.search("ACAB"))
  println(t.search("ABCD"))
  println(t.search("ABCDE"))
  println(t.search("ABC"))
  println(t.startsWith("ACA"))
  println(t.startsWith("ACAD"))
}


trait TTrie {
  def insert(word: String)

  def search(word: String): Boolean

  def startsWith(prefix: String): Boolean
}

class TrieNode(initChar: Char, isEndOfWord: Boolean) {
  val char = initChar
  var endOfWord = isEndOfWord
  val childs: mutable.Map[Char, TrieNode] = new mutable.HashMap[Char, TrieNode]()
}

class Trie extends TTrie {
  var root: TrieNode = new TrieNode(' ', false)

  def insert(word: String) = {
    def insertInternal(node: TrieNode, word: String): Boolean = {

      val c = node.childs.getOrElseUpdate(word.charAt(0), {
        new TrieNode(word.charAt(0), word.length == 1)
      })
      if (word.length == 1) {
        c.endOfWord = true
        true
      } else insertInternal(c, word.substring(1))

    }
    insertInternal(root, word)


  }

  def search(word: String): Boolean = {
    def searchInternal(node: TrieNode, word: String): Boolean = {
      val c = node.childs.get(word.charAt(0))
      if (c.isEmpty) false
      else {
        if (c.get.endOfWord && word.length == 1) true
        else {
          if (word.length == 1) false
          else searchInternal(c.get, word.substring(1))
        }
      }

    }
    return searchInternal(root, word)
  }

  def startsWith(prefix: String): Boolean = {
    def startsInternal(node: TrieNode, prefix: String): Boolean = {
      val c = node.childs.get(prefix.charAt(0))
      if (c.isEmpty) false
      else {
        if (prefix.length == 1) true
        else startsInternal(c.get, prefix.substring(1))

      }

    }
    return startsInternal(root, prefix)
  }
}
