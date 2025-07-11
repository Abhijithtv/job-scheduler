<p align="center">
    <img src="https://raw.githubusercontent.com/PKief/vscode-material-icon-theme/ec559a9f6bfd399b82bb44393651661b08aaf7ba/icons/folder-markdown-open.svg" align="center" width="30%">
</p>
<h1 align="center">JOB-SCHEDULER</h1>

<p align="center">
	<em><code>A lightweight, extensible job scheduling framework written in Java, supporting persistent scheduling, recurring jobs, and custom thread pool management.</code></em>
</p>
<p align="center">
	<img src="https://img.shields.io/github/license/Abhijithtv/job-scheduler?style=default&logo=opensourceinitiative&logoColor=white&color=0080ff" alt="license">
	<img src="https://img.shields.io/github/last-commit/Abhijithtv/job-scheduler?style=default&logo=git&logoColor=white&color=0080ff" alt="last-commit">
	<img src="https://img.shields.io/github/languages/top/Abhijithtv/job-scheduler?style=default&color=0080ff" alt="repo-top-language">
	<img src="https://img.shields.io/github/languages/count/Abhijithtv/job-scheduler?style=default&color=0080ff" alt="repo-language-count">
</p>

---

## 📌 Overview

This project is a **Job Scheduler** that supports:

- One-time and recurring job execution
- Redis-backed storage
- Configurable thread pools
- Job queuing and retry mechanisms
- Custom worker logic and status tracking

It's built using Spring Boot with Redis and an optional relational DB for persistence.

---

## ✨ Features

- ⏱ Schedule jobs for future execution
- 🔁 Recurring job support
- ❗ Job retries and failure tracking
- 🔄 Redis-backed task queueing (ZSET optional)
- 🧵 Configurable custom thread pool
- ⚙️ Worker system to process jobs in parallel
- 💾 Spring Boot + JPA integration for persistent storage
- 🔐 Bean-configurable startup system

---

## 🏗 Project Structure

```sh
job-scheduler/
├── pom.xml
├── mvnw / mvnw.cmd
└── src
    ├── main/
    │   └── java/com/example/job_scheduler/
    │       ├── Common/
    │       ├── Config/
    │       ├── Controllers/
    │       ├── Enums/
    │       ├── Fillers/
    │       ├── Helpers/
    │       ├── Models/
    │       ├── Repository/
    │       ├── Services/
    │       └── Starters/
    └── test/
