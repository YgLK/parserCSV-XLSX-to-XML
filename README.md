<h1 align="center"> parserCSV-XLSX-to-XML

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
[![Generic badge](https://img.shields.io/badge/MAVEN-3.8.1-brightgreen.svg)](https://shields.io/)
[![Generic badge](https://img.shields.io/badge/coverage-72/100-green.svg)](https://shields.io/)

 
## Table of Contents

- [Instructions](#instructions)
- [Compatible data](#data)
- [Delimeters in the CSV file](#delim)
- [Javadoc & SonarQube raport](#doc_scube)


## Instructions <a name="instructions"></a>
  
1. Build the project with Maven.
2. Find target directory in the main module.
3. Copy/move Java JAR file to the location where CSV/XLSX files are.
4. Run the file from your terminal after moving to the target directory in the poker-server module by entering this command: <br>
    ***FOR CSV FILES***: <br>
    `java -jar .\main-1.0-jar-with-dependencies.jar fileToConvert.csv outputFilename.xml` <br>
    ***FOR XLSX FILES***: <br>
    `java -jar .\main-1.0-jar-with-dependencies.jar fileToConvert.xlsx outputFilename.xml`
5. Output XML file is located in the same directory as Java JAR file. <br>

  
## Data <a name="data"></a>
  Parser is compatible and built for the use with [dane.csv](https://github.com/YgLK/parserCSV-XLSX-to-XML/blob/dev/multi-module/dane.csv) or [dane.xlsx](https://github.com/YgLK/parserCSV-XLSX-to-XML/blob/dev/multi-module/dane.xlsx) files.

## Delimeters in the CSV file <a name="delim"></a>
  You can change delimiters for CSV here: <br>
`ReaderCSV.java in the line 58 [Current delimiter: "\t"]`
  
## Javadoc & SonarQube raport <a name="doc_scube"></a>
 In order to explore `Javadoc` or `SonarQube raport` download appropriately `javadoc` or `sonar-cube` directory,<br> open them and for:
 > `Javadoc`: open [allclasses.html](https://github.com/YgLK/parserCSV-XLSX-to-XML/blob/dev/javadoc/allclasses.html) file <br> Then the project documentation will appear.
 
 or 
 
 > `SonarQube raport`: <br> 
> open [Przyklad - aplikacja wielomodulowa.html](https://github.com/YgLK/parserCSV-XLSX-to-XML/blob/dev/sonar-cube/Przyklad%20-%20aplikacja%20wielomodulowa.html) <br> Then project test coverage will appear. <br>
> open [Issues.html](https://github.com/YgLK/parserCSV-XLSX-to-XML/blob/dev/sonar-cube/Issues.html) <br>Then project code smells (issues) raport will appear.
