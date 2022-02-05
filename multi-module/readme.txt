        Parser CSV/XLSX to XML
    How to run:
1. Build the project with Maven.
2. Find target directory in the main module.
3. Copy/move Java JAR file to the location where CSV/XLSX files are.
4. Run the file from your terminal after moving to the target directory in the poker-server module by entering this command:
    FOR CSV FILES:
    java -jar .\main-1.0-jar-with-dependencies.jar fileToConvert.csv outputFilename.xml
    FOR XLSX FILES:
    java -jar .\main-1.0-jar-with-dependencies.jar fileToConvert.xlsx outputFilename.xml
5. Output XML file is located in the same directory as Java JAR file.

Parser is compatible and built for the use with dane.csv or dane.xlsx files.

You can change delimiters for CSV here:
ReaderCSV.java in the line 58 [Current delimiter: "\t"]
