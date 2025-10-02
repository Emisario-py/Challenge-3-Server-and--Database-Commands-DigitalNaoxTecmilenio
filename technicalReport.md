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

---

# Response Formats  

- Responses are in **JSON** and **HTML**.  
- Contain metadata (author, title, citation count, year, etc.).  
- Include nested objects for citations, co-authors, and article details.  

---

# Usage Limits  

- **Free plan:** 100 searches per month.  
- **Paid plans:** Higher request limits depending on subscription.  
