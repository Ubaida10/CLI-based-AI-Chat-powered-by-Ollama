# CLI-Based AI Chat Poweref By Ollama

A Spring Boot console application that lets you chat interactively with a local LLM using **Spring AI** and **Ollama** (running the `smollm2` model). Type a prompt, get a response — repeat until you're done.

---

## Project Overview

This project demonstrates how to integrate Spring AI with a locally running Ollama instance to create an interactive chat experience entirely in the terminal. No API keys, no cloud costs — everything runs on your machine.

**Tech stack:**
- Java 17
- Spring Boot 3.4.5
- Spring AI 1.0.0 (`spring-ai-starter-model-ollama`)
- Ollama with `smollm2` model

---

## Prerequisites & Setup

### 1. Java 17+
Make sure Java 17 or higher is installed:
```bash
java -version
```

### 2. Install Ollama
Download and install Ollama from [https://ollama.com/download](https://ollama.com/download).

Then pull the `smollm2` model:
```bash
ollama pull smollm2
```

Verify it works:
```bash
ollama run smollm2 "Say hello"
```

### 3. Clone the Repository
```bash
git clone <your-repo-url>
cd ClaudePromptService
```

---

## How to Run

You need **two terminals** running simultaneously.

**Terminal 1 — Start Ollama:**
```bash
ollama serve
```

**Terminal 2 — Start the Spring Boot app:**
```bash
./mvnw spring-boot:run
```

> **Note:** Run in a real terminal, not your IDE's built-in console. In IntelliJ, go to **Run → Edit Configurations → Enable "Run in terminal"** for interactive input to work correctly.

Type your prompt and press `Enter` to get a response. Type `exit` or `quit` to stop.

---

## Example Output

```
╔══════════════════════════════════════╗
║       AI Chat — powered by Ollama    ║
║       Type 'exit' to quit            ║
╚══════════════════════════════════════╝

You: What is dependency injection?
AI:  Dependency injection is a design pattern where an object receives
     its dependencies from an external source rather than creating them
     itself. It promotes loose coupling and makes code easier to test.
──────────────────────────────────────────────────────

You: Give me a Java example
AI:  Sure! Here's a simple example...
──────────────────────────────────────────────────────

You: exit
Goodbye!
```
