        Parser CSV/XLSX to XML
    How to run:
1. Build the project with Maven.
2. Find target directory in the main module.
3. Copy/move Java JAR file to the location where CSV/XLSX files.
4. Run the Server from your terminal after moving to the target directory in the poker-server module by entering this command:
    FOR CSV FILES:
    java -jar .\main-1.0-jar-with-dependencies.jar fileToConvert.csv outputFilename.xml
    FOR XLSX FILES:
    java -jar .\main-1.0-jar-with-dependencies.jar fileToConvert.xlsx outputFilename.xml
5. Output XML file is located in the same directory as Java JAR file.

Parser is compatible and built for the use with faktury-sprzedazowe-test.csv file.
Convert it to the XLSX file and run the parser to see that it works either.