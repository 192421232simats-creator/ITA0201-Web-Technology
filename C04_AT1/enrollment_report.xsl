<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" encoding="UTF-8"/>

    <xsl:template match="/">

        <html>
            <head>
                <title>High Enrollment Courses</title>

                <style>
                    body {
                        margin: 0;
                        font-family: Arial, sans-serif;
                        background: #e8f5f2;
                        color: #1f2937;
                    }

                    .container {
                        width: 90%;
                        max-width: 1100px;
                        margin: 40px auto;
                        background: white;
                        padding: 30px;
                        border-radius: 15px;
                        box-shadow: 0 5px 20px rgba(0,0,0,0.12);
                    }

                    h1 {
                        text-align: center;
                        color: #075e54;
                        margin-bottom: 10px;
                    }

                    .subtitle {
                        text-align: center;
                        color: #64748b;
                        margin-bottom: 30px;
                    }

                    table {
                        width: 100%;
                        border-collapse: collapse;
                        overflow: hidden;
                        border-radius: 10px;
                    }

                    th {
                        background: #0f766e;
                        color: white;
                        padding: 14px;
                        text-align: left;
                    }

                    td {
                        padding: 13px;
                        border-bottom: 1px solid #dbe4e8;
                    }

                    tr:nth-child(even) {
                        background: #f0fdfa;
                    }

                    tr:hover {
                        background: #ccfbf1;
                    }

                    .students {
                        font-weight: bold;
                        color: #0f766e;
                    }

                    .filter {
                        margin-top: 25px;
                        padding: 15px;
                        background: #ecfdf5;
                        border-left: 5px solid #0f766e;
                        border-radius: 6px;
                    }

                    .footer {
                        text-align: center;
                        margin-top: 25px;
                        color: #64748b;
                        font-size: 14px;
                    }
                </style>
            </head>

            <body>

                <div class="container">

                    <h1>High Enrollment Courses</h1>

                    <p class="subtitle">
                        University Course Enrollment Analysis
                    </p>

                    <table>

                        <tr>
                            <th>Course Code</th>
                            <th>Course Name</th>
                            <th>Faculty</th>
                            <th>Students</th>
                            <th>Credits</th>
                            <th>Type</th>
                        </tr>

                        <!-- Select courses having more than 40 students -->
                        <xsl:for-each select="courses/course[students &gt; 40]">

                            <!-- Sort students in descending order -->
                            <xsl:sort
                                select="students"
                                data-type="number"
                                order="descending"/>

                            <tr>

                                <td>
                                    <xsl:value-of select="code"/>
                                </td>

                                <td>
                                    <xsl:value-of select="name"/>
                                </td>

                                <td>
                                    <xsl:value-of select="faculty"/>
                                </td>

                                <td class="students">
                                    <xsl:value-of select="students"/>
                                </td>

                                <td>
                                    <xsl:value-of select="credits"/>
                                </td>

                                <td>
                                    <xsl:value-of select="type"/>
                                </td>

                            </tr>

                        </xsl:for-each>

                    </table>

                    <div class="filter">
                        <strong>Applied Filter:</strong>
                        Courses with more than 40 students.
                        <br/>
                        <strong>Sorting:</strong>
                        Student enrollment in descending order.
                    </div>

                    <div class="footer">
                        Web Technology – Unit IV | XSLT Course Report
                    </div>

                </div>

            </body>
        </html>

    </xsl:template>

</xsl:stylesheet>