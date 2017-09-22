package net.rayxiao

/**
  * Created by rxiao on 7/7/16.
  */
object WordSearchII extends App {
  val words = Array("oath", "pea", "eat", "rain")
  val board = Array(
    Array('o', 'a', 'a', 'n'),
    Array('e', 't', 'a', 'e'),
    Array('i', 'h', 'k', 'r'),
    Array('i', 'f', 'l', 'v')
  )

  def findWords(board: Array[Array[Char]], words: Array[String]): Array[String] = {
    val trie = new Trie()
    var result = Array[String]()

    def dfs(rowIdx: Int, colIdx: Int, visited: Array[Array[Boolean]], word: String): Boolean = {
      if (rowIdx < 0 || colIdx < 0 || rowIdx >= board.length || colIdx >= board(0).length) return false
      if (visited(rowIdx)(colIdx)) return false

      val newWord = word + board(rowIdx)(colIdx).toString
      if (trie.search(newWord)) {
        result :+= newWord
        return true
      } else if (trie.startsWith(newWord)) {

        visited(rowIdx)(colIdx) = true
        dfs(rowIdx - 1, colIdx, visited, newWord)
        dfs(rowIdx + 1, colIdx, visited, newWord)
        dfs(rowIdx, colIdx - 1, visited, newWord)
        dfs(rowIdx, colIdx + 1, visited, newWord)
        visited(rowIdx)(colIdx) = false
        return false
      } else return false
    }

    words.map(trie.insert)
    var visited = Array.ofDim[Boolean](board.length, board(0).length)
    board.zipWithIndex.map {
      case (row, rowIdx: Int) => row.zipWithIndex.map {
        case (element, colIdx: Int) => dfs(rowIdx, colIdx, visited, "")
      }
    }
    result
  }

  findWords(board, words).foreach(println)
}
