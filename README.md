# AI Panel

## 🚧 Status: Under Construction 🚧

AI Panel is a multi-user AI chat platform designed to provide personalized artificial intelligence experiences. Unlike generic chat interfaces, AI Panel allows users to architect their own AI personas by defining specific behaviors through custom system prompts.


## ✨ Key Features
- User Management & Security: Robust account creation and management system, ensuring that every user has a private and secure workspace.
- Customizable Chatbots: Users can create multiple unique chatbots. By crafting specific "System Prompts," users can define the personality, expertise, and constraints of each bot (e.g., a coding assistant, a creative writer, or a historical figure).
- Persistent Chat Memory: Powered by MongoDB, the platform maintains conversational context, allowing for long-term, meaningful interactions that remember previous exchanges.
- Local AI Integration: Built with a "Local-First" mindset using Ollama, providing privacy and reducing reliance on expensive cloud APIs.
- Modern Web Interface: A seamless, reactive, and component-based UI built with Vaadin, offering a desktop-class web experience.
 
## 🛠 Tech Stack
### Backend
- Java 25: Utilizing the latest features of the Java ecosystem.
- Spring Boot: The core framework driving the application logic.
- Spring AI: Orchestrating the interactions between the application and Large Language Models (LLMs).
- Spring Security: Managing authentication and authorization.
- Lombok: Reducing boilerplate code for a cleaner codebase.

### Frontend
- Vaadin: A modern web framework that allows building rich user interfaces entirely in Java.

### Data & Persistence
- PostgreSQL: Handles relational data, including user profiles, account settings, and chatbot configurations.
- Flyway: Manages database schema migrations to ensure consistent environments.
- MongoDB: Serves as a high-performance document store for chat histories and AI memory/context.

### AI & Infrastructure
- Ollama: Local LLM runner for privacy-focused AI generation.
- Docker / Testcontainers: Used for seamless local development and robust integration testing of databases and AI services.

## 📄 License
### MIT License

Copyright (c) 2026 Markus Großhäuser

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.