# 🚀 Project Purpose  
The main goal of the project is to **automate the integration of information about researchers and their published articles** by using the **Google Scholar API**, ensuring that the institution’s research database is kept updated without relying on manual processes.  

---

# 💫 Key Functionalities  

- **Data Retrieval:** Connect to the Google Scholar API to extract information about researchers and their publications.  
- **Data Processing:** Parse the JSON response and map the fields to the institution’s research database structure.  
- **Database Integration:** Store the retrieved data in the university’s research database, handling pagination and API errors.  
- **Automation & Reporting:** Update the information of the Top 3 researchers automatically, facilitating the generation of scientific production reports.  
- **Version Control & Documentation:** Manage the entire development process through GitHub with proper documentation and testing.  

---

# 📝 Project Relevance  
The project solves the **problem of manual and repetitive data entry** currently used to track researcher output. By automating this process:  

- ✅ Saves time and reduces human error in data management.  
- ✅ Provides up-to-date and accurate information for scientific reports.  
- ✅ Supports institutional decision-making by making research data readily available.  
- ✅ Strengthens collaboration between programmers and database managers, promoting efficient workflows.  

---

# 🚧 Project requirements

## Software Requirements
| Component                      | Version                           | Description                                                           |
| ------------------------------ | --------------------------------- | --------------------------------------------------------------------- |
| **Java Development Kit (JDK)** | 17 or higher                      | Required for compiling and running the Spring Boot application.       |
| **Apache Maven**               | 3.8+                              | Dependency and build management tool.                                 |
| **Spring Boot**                | 3.5.x                             | Framework used for building the REST API and managing configurations. |
| **MySQL Server**               | 8.0+                              | Relational database for storing article and author information.       |
| **IDE (Optional)**             | IntelliJ IDEA / VS Code / Eclipse | For development, code navigation, and debugging.                      |
| **SerpApi Account**            | -                                 | Needed to obtain the API key for Google Scholar data.                 |
---
## 🗄️ Database Configuration
Create a database in MySQL:
```sql
CREATE DATABASE scholar_db;
```
Then, configure your credentials in: **src/main/resources/application.properties:**
```java
spring.datasource.url=jdbc:mysql://localhost:3306/scholar_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

serpapi.base-url=https://serpapi.com/search.json
serpapi.api-key=YOUR_SERPAPI_KEY
```
---
## 🧰 Build & Run Instructions
1. Clone the repository.
```cmd
git clone https://github.com/yourusername/Challenge-3-Server-and--Database-Commands-DigitalNaoxTecmilenio.git

cd App
```
2. Build the project
```cmd
mvn clean install
```
3. Run the application
```cmd
mvn spring-boot:run
```
4. The API will be available at **http://localhost:8080**
---
| Method | Endpoint                    | Description                                                |
| ------ | --------------------------- | ---------------------------------------------------------- |
| `GET`  | `/authors/{id}`             | Retrieves author information from SerpApi.                 |
| `POST` | `/articles/{authorId}/sync` | Fetches and saves articles from SerpApi into the database. |
| `GET`  | `/articles/{authorId}`      | Returns the stored articles for the specified author.      |
---
### 🧱 Example Response
```json
{
  "author": {
    "name": "Cliff Meyer",
    "affiliations": "Dana-Farber Cancer Institute and Harvard T.H. Chan School of Public Health"
  },
  "articles": [
    {
      "title": "Model-based analysis of ChIP-Seq (MACS)",
      "authors": "Y Zhang, T Liu, CA Meyer, ...",
      "publication": "Genome Biology 9 (9), 1–9, 2008",
      "cited_by": { "value": 9186 }
    }
  ]
}
```
## 🧤 Tools

**Postman / Insomnia or others** – To test endpoints manually.
