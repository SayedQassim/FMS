Family Grocery List Management System
Project Description
This project is a Spring Boot-based application designed for managing family grocery lists with multi-tenancy support. Each user can create a family, register members, and manage shared grocery lists and items. The project includes user authentication and authorization, and email verification for account activation.

Tools and Technologies Used
Java: Main language for the backend.
Spring Boot: Framework for building the backend REST API.
Spring Security: For authentication and authorization.
JWT (JSON Web Tokens): For secure authentication.
Hibernate & JPA: For database interaction and ORM mapping.
PostgreSQL: Relational database used for data persistence.
Docker: Containerization of the application.
JUnit: For unit testing.
Maven: Dependency management.
GitHub: Version control and project tracking.
Approach
The project is structured around the Spring Boot MVC pattern with distinct layers for controllers, services, and repositories. Each layer is designed to handle specific responsibilities, ensuring separation of concerns and testability.

The multitenancy feature is implemented using a TenantContext class to handle the specific data partitioning per family, ensuring data isolation across different families. User roles and statuses are managed to control access to family and grocery list features.

The grocery list feature is modular, allowing users to create a list first and then add items to it individually, enhancing flexibility. Email verification and invitation mechanisms are incorporated to handle user authentication and family membership management.

Challenges and Solutions
Multitenancy: Implementing tenant-based isolation required a custom approach to inject tenant-specific logic into database queries.
Initial Family Assignment: Handling scenarios where new users have not yet joined or created a family. A placeholder status is used until a family is assigned.
Email Verification: Ensuring smooth and secure registration through email verification links.
Complex Query Requirements: Managing family-specific queries required custom specifications in Hibernate.
User Stories
As a new user, I want to register and verify my email to access the app.
As a family member, I want to manage shared grocery lists with my family.
As a family admin, I want to invite other users to join my family and manage family-specific data.
Link to User Stories (replace with actual link)

ERD Diagram
Link to ERD (replace with actual link)

Planning and Timeline
The project was broken down into several phases, with user authentication, family management, and grocery list features prioritized in the initial stages. The timeline included detailed milestones for each phase, ensuring the delivery of core features before additional enhancements.
