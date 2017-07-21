package io.github.loustler.abstractInternalControl

import java.io.File

/**
  * This is have no test codes.
  *
  * @author loustler
  * @since 07/21/2017 21:08
  */
object FileMatcher {
  private def filesHere = (new File(".")).listFiles

  def filesEnding(query: String) =
    for (file <- filesHere; if file.getName.endsWith(query))
      yield file

  def fileContaining(query: String) =
    for (file <- filesHere; if file.getName.contains(query))
      yield file

  def fileRegex(query: String) =
    for (file <- filesHere; if file.getName.matches(query))
      yield file

  // Upper functions has duplicate source. It was not good.
  def fileMatching(matcher: String => Boolean) =
    for (file <- filesHere; if matcher(file.getName))
      yield file

  // It is like fileEncoding function.
  def filesEncoding2(query: String) =
    //    fileMatching(query, (fileName, query) => fileName.endsWith(query))
    fileMatching(_.endsWith(query))

  // It is like fileContaining function.
  def fileContaining2(query: String) =
    //    fileMatching(query, (fileName, query) => fileName.contains(query))
    fileMatching(_.contains(query))

  // It is like fileRegex function.
  def fileRegex2(query: String) =
    //    fileMatching(query, (fileName, query) => fileName.matches(query))
    fileMatching(_.matches(query))
}
