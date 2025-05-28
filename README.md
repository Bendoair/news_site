# 🇭🇺 Kotlin Multiplatform News Aggregator

A prototype application for a Hungarian news aggregator, built using Kotlin Multiplatform (KMP) and Compose Multiplatform. Inspired by platforms like Ground News, this app aims to surface regionally relevant and balanced news content from various sources via RSS feeds.

---

## 🎯 Purpose

In today's information overload, finding unbiased and diverse viewpoints is difficult. While apps like Ground News offer great insight into media bias, they are often centered around Western and U.S.-specific content.

This application is built to:

- Aggregate Hungarian and regional news.
- Present multiple sources to identify bias.
- Lay the groundwork for AI-assisted news summarization and analysis.

---

## 🧩 Current Features

- Cross-platform (Desktop & Mobile) news app using Kotlin Multiplatform.
- Pulls data from RSS feeds.
- Opens full news content in external browser.
- Basic category filtering and navigation.

---

## 🛠️ Tech Stack

| Technology      | Purpose                                      |
|----------------|----------------------------------------------|
| Kotlin MPP      | Shared business logic across all platforms   |
| Compose MPP     | Unified declarative UI                       |
| Ktor Client     | HTTP client to fetch RSS feeds               |
| KoIn            | Dependency Injection                         |
| Voyager         | Navigation library for multiplatform apps    |

---

## 🧱 Architecture

A clean 3-layer architecture:

- **Presentation Layer**: Compose UI, Voyager Navigation, State Management
- **Domain Layer**: Use-cases, Interfaces, Models
- **Data Layer**: Ktor API calls, Repositories, DTOs, RSS Processing

---

## 🧪 Compose Multiplatform Insights

Compose MPP brings Jetpack Compose to:

- Android (via Dalvik bytecode)
- Desktop (JVM JARs)
- Web (via WebAssembly)
- iOS (Canvas-based rendering)

⚠️ Web and iOS support are still alpha.

---

## 🔮 Future Plans

- **AI Integration**: Summarization & bias detection (backend service)
- **Personalized Feed**: Based on user preferences and login
- **iOS & Web support**: Once platform APIs are more stable

---

## 📄 License

MIT or TBD

---

Made with ❤️ using Kotlin Multiplatform and JetBrains tools.
