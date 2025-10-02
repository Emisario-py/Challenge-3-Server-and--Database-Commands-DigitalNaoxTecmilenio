# Endpoints  

- **Author API**  
  Allows you to scrape author results from the Google Scholar Author search page.  
  **Endpoint:** `https://serpapi.com/search?engine=google_scholar_author`  

- **Cite API**  
  Allows you to scrape citation results from the Google Scholar organic results.  
  **Endpoint:** `https://serpapi.com/search?engine=google_scholar_cite`  

- **Profiles API**  
  Allows you to scrape profile results from the Google Scholar Profiles search page.  
  **Endpoint:** `https://serpapi.com/search?engine=google_scholar_profiles`  

---

# Authentication Methods  

- Requires an **API key** from SerpApi.  
- Pass via query parameter: `api_key=YOUR_KEY`  
- Sign up for a free account to obtain the key.  

---

# Query Parameters  

- `q` → Search query (e.g., author name, article title).  
- `api_key` → Defines the SerpApi private key to use.  
- `hl` → Language (e.g., `en`).  
- `start` → Pagination offset.  
- `num` → Number of results (up to 20 per page).  
- `author_id` → Unique Google Scholar author ID (for Author API).  
- `view_op` → Citation style for Cite API.  

---

# Response Formats  

- Responses are in **JSON** and **HTML**.  
- Contain metadata (author, title, citation count, year, etc.).  
- Include nested objects for citations, co-authors, and article details.  

---

# Usage Limits  

- **Free plan:** 100 searches per month.  
- **Paid plans:** Higher request limits depending on subscription.  

---

# Code Examples  

### Java  
```java
Map<String, String> parameter = new HashMap<>();

parameter.put("engine", "google_scholar");
parameter.put("q", "biology");
parameter.put("api_key", "YOUR_API_KEY");

GoogleSearch search = new GoogleSearch(parameter);

try {
  JsonObject results = search.getJson();
  var organic_results = results.get("organic_results");
} catch (SerpApiSearchException ex) {
  System.out.println("Exception:");
  System.out.println(ex.toString());
}
```
### Python
```python
from serpapi import GoogleSearch

params = {
  "engine": "google_scholar",
  "q": "biology",
  "api_key": "YOUR_API_KEY"
}

search = GoogleSearch(params)
results = search.get_dict()
organic_results = results["organic_results"]
```