/**
 This application is for demonstration use only. It contains known application security
vulnerabilities that were created expressly for demonstrating the functionality of
application security testing tools. These vulnerabilities may present risks to the
technical environment in which the application is installed. You must delete and
uninstall this demonstration application upon completion of the demonstration for
which it is intended. 

IBM DISCLAIMS ALL LIABILITY OF ANY KIND RESULTING FROM YOUR USE OF THE APPLICATION
OR YOUR FAILURE TO DELETE THE APPLICATION FROM YOUR ENVIRONMENT UPON COMPLETION OF
A DEMONSTRATION. IT IS YOUR RESPONSIBILITY TO DETERMINE IF THE PROGRAM IS APPROPRIATE
OR SAFE FOR YOUR TECHNICAL ENVIRONMENT. NEVER INSTALL THE APPLICATION IN A PRODUCTION
ENVIRONMENT. YOU ACKNOWLEDGE AND ACCEPT ALL RISKS ASSOCIATED WITH THE USE OF THE APPLICATION.

IBM AltoroJ
(c) Copyright IBM Corp. 2008, 2013 All Rights Reserved.
 */

package com.ibm.security.appscan.altoromutual.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SurveyServlet
 * @author Alexei
 */
public class SurveyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SurveyServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String step = request.getParameter("step");
        String content = null;
        String previousStep = null;

        if (step == null)
            step = "";

        if (step.equals("a")) {
            content = "<h1>Question 1</h1>" +
                    "<div width=\"99%\"><p>Which of the following groups includes your age?<ul>  <li><a href=\"survey_questions.jsp?step=b\">13 years or less</a></li>  <li><a href=\"survey_questions.jsp?step=b\">14-17</a></li>  <li><a href=\"survey_questions.jsp?step=b\">18-24</a></li>  <li><a href=\"survey_questions.jsp?step=b\">25-34</a></li>  <li><a href=\"survey_questions.jsp?step=b\">35-44</a></li>  <li><a href=\"survey_questions.jsp?step=b\">45-54</a></li>  <li><a href=\"survey_questions.jsp?step=b\">55-64</a></li>  <li><a href=\"survey_questions.jsp?step=b\">65-74</a></li>  <li><a href=\"survey_questions.jsp?step=b\">75+</a></li></ul></p></div>";
            previousStep = "";
        } else if (step.equals("b")) {
            content = "<h1>Question 2</h1>" +
                    "<div width=\"99%\"><p>Have you bookmarked our website?<ul><li><a href=\"survey_questions.jsp?step=c\">Yes</a></li>  <li><a href=\"survey_questions.jsp?step=c\">No</a></li></ul></p></div>";
            previousStep = "a";
        }
        // Other conditions...

        // Sanitize content before rendering
        content = StringEscapeUtils.escapeHtml4(content);

        response.setContentType("text/html");
        response.getWriter().write(content);
        response.getWriter().flush();
    }
}
