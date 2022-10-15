package com.kulgeiko.scala.tasks

/*
Your task is to write a function to take in a game board and determine which player should make the next move.

Each player moves by marking a space on the board. The player with the least number of spaces marked must make the next move.
However, Player 1 will move first if the board is empty, and Player 2 will go next if there is an equal number of spaces marked .
This is strictly a two player game.

Your function should return '1' if the turn belongs to Player 1, or '2' if Player 2 Player 1 will move first if the board is
empty, and Player 2 will go next if there is an equal number of spaces marked.
 */


object Karat1 {

  val board1 = Array(
    Array(0,2,0,1),
    Array(0,2,1,0),
    Array(2,1,0,2),
    Array(1,2,0,0) // => 1
  )
  val board2 = Array(1,2,0) // => 2
  val board3 = Array(1,1,0) // => 2
  val board4 = Array(0,0,0) // => 1

  def countMove(arr: Array[Int], player: Int): Int = arr.count(p => p == player)

  def nextMove(arr: Array[Int]) = {

    val player1MovesNum = countMove(arr, 1)
    val player2MovesNum = countMove(arr, 2)

    if (player1MovesNum == 0 && player2MovesNum == 0)
      1
    else if (player1MovesNum == player2MovesNum)
      2
    else if (player1MovesNum > player2MovesNum)
      2
    else
      1
  }

  def main(args: Array[String]): Unit = {
    println(Array(1,2,3))
    //val ff = board2.flatMap(t => t*5)
    val board1Flatten = board1.flatten
    println(nextMove(board1Flatten))
    println(nextMove(board2))
    println(nextMove(board3))
    println(nextMove(board4))
  }
}


