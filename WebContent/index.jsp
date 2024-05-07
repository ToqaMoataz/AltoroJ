<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
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
%> 
    
<jsp:include page="header.jspf"/>

<div id="wrapper" style="width: 99%;">
    <jsp:include page="toc.jspf"/>
    <td valign="top" colspan="3" class="bb">
        <%
        String content = request.getParameter("content");
        if (content == null || content.isEmpty())
            content = "default.htm";

        // Constructing the absolute path to the requested content file
        String filePath = getServletContext().getRealPath("/static/" + content);

        // Check if the requested file exists
        File file = new File(filePath);
        if (file.exists() && !file.isDirectory()) {
            // Read the content of the file safely
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    out.println(line);
                }
                reader.close();
            } catch (IOException e) {
                out.println("Failed to read file: " + e.getMessage());
            }
        } else {
            out.println("File not found: " + content);
        }
        %>
    </td>
</div>

<jsp:include page="footer.jspf"/>
