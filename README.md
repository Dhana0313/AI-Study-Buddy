# 🎓 AI Study Buddy

> An intelligent, full-stack study assistant that uses **Retrieval Augmented Generation (RAG)** to turn your static PDF notes into an interactive chat experience.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.2-green)
![Spring AI](https://img.shields.io/badge/Spring_AI-1.0.0_M5-blue)
![Docker](https://img.shields.io/badge/Docker-Enabled-blue)
![Railway](https://img.shields.io/badge/Deployed_on-Railway-white)

---

## 📖 Overview

**AI Study Buddy** is a personalized tutor application designed to help students and developers learn faster. Unlike generic chatbots, this application allows users to **upload their own PDF documents** (lecture notes, textbooks, resumes) and chat specifically about that content.

It uses a **RAG (Retrieval Augmented Generation)** pipeline to:
1.  **Ingest** PDF documents.
2.  **Chunk & Embed** the text into vector representations.
3.  **Store** embeddings in a local Vector Database.
4.  **Retrieve** relevant context to answer user queries accurately.



---

## ✨ Features

### 🤖 **Interactive AI Tutor**
* Chat with a helpful AI assistant powered by **Groq / OpenAI**.
* Remembers context from your conversation (Chat Memory).

### 📚 **Chat with Your Notes (RAG)**
* **Upload PDFs:** Simply click the 📎 icon to upload lecture slides or documents.
* **Context-Aware Answers:** The AI reads your document and answers questions based *only* on the provided material.
* **Vector Search:** Uses local embeddings to find the exact paragraph needed to answer your question.

### 📝 **Smart Quiz Generator**
* Ask the bot to "Give me a quiz on [Topic]" and it generates a multiple-choice question.
* Instant feedback on your answers.

### 🚀 **Production Ready**
* **Dockerized:** Fully containerized for easy deployment.
* **Cloud Hosted:** Deployed and running on **Railway**.

---

## 🛠️ Tech Stack

### **Backend**
* **Java 21**
* **Spring Boot 3.4.2** (Web, Actuator)
* **Spring AI 1.0.0-M5** (The core AI framework)
* **Apache PDFBox** (Document parsing)
* **SimpleVectorStore** (Local Vector Database)

### **Frontend**
* **HTML5 / CSS3** (Clean, responsive chat UI)
* **JavaScript (Vanilla)** (Fetch API for streaming responses & file uploads)

### **Infrastructure**
* **Docker** (Containerization)
* **Railway** (Cloud Platform)
* **Maven** (Build Tool)

    E -- Response --> A
