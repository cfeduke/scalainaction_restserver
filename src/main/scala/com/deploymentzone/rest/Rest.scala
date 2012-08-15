package com.deploymentzone.rest

import org.scalatra._
import scalate.ScalateSupport
// for asScala methods
import scalaj.collection.Imports._

// MethodOverride adds support for HTTP DELETE conventions
class Rest extends ScalatraServlet with ScalateSupport with MethodOverride {

  get("/") {
    """GET method called
parameters: %s
headers: %s
""".format(paramsAsString, headersAsString)
  }

  post("/") {
    """POST method called
parameters: %s
headers: %s
    """.format(paramsAsString, headersAsString)
  }

  delete("/") {
    """DELETE method called"""
  }

  def paramsAsString() = {
    params.map { case(key, value) => "|%s->%s".format(key, value) } mkString
  }

  def headersAsString() = {
    (request getHeaderNames).asScala.map { case(headerName:String) => "|%s->%s".format(headerName, 
      request.getHeader(headerName)) } mkString
  }

  notFound {
    // remove content type in case it was set through an action
    contentType = null 
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound() 
  }
}
