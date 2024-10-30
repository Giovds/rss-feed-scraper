# RSS Feed Scraper

This application scrapes RSS feeds provided by the user and fetches all blogs and articles posted by authors within a specified year. The fetched data is displayed in the console with a list of articles within that year per author.

## How to Build and Run the Application

1. Clone the repository:
   ```
   git clone https://github.com/githubnext/workspace-blank.git
   cd workspace-blank
   ```

2. Build the application using Maven:
   ```
   mvn clean package
   ```

3. Run the application:
   ```
   java -jar target/rss-feed-scraper-1.0-SNAPSHOT.jar
   ```

4. Follow the prompts to enter the RSS feed URLs (comma separated) and the year.

## Dependencies

The application uses the following libraries:
- `rome` version `2.1.0` for RSS feed parsing
- `slf4j-api` and `slf4j-simple` for logging
