~~Back-end~~ / Java, Spring Boot, RestAPI, UnitTest, Spring Security, PostgreSQL, NoSQL, Maven~Tomcat

~~Front-End~~ / JavaScript, ReactJS, Redux

~~Deploying~~ / AWS, Docker, Kubernetes


#### Review to Models

Student - Instructor - Lesson 
    
###### 1 - Student ~ With Standard technique 
    
        Description for Annotations 
            @Entity 
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column('student_id')

<a href="https://github.com/omeryzr/miniSchool/blob/main/src/main/java/com/miniSchool/MiniSchool/models/Student.java">Click to review of Student model codes </a>
     
###### 2 - Instructor ~ Create with Lombok
    
      add in the file of pom.xml
      
      <dependencies>
          ...
          <dependency>
              <groupId>org.projectlombok</groupId>
              <artifactId>lombok</artifactId>
              <version>1.18.10</version>
              <scope>provided</scope>
          </dependency>
          ...
      </dependencies>

After added dependency
       
       @Getter
       @Setter
       @NoArgsConstructor
       
<a href="https://github.com/omeryzr/miniSchool/blob/main/src/main/java/com/miniSchool/MiniSchool/models/Instructor.java">Click to review of Instructor model codes </a>



###### Review to Repository

add Jpa dependency in pom.xml

        <dependency>
            <groupId>org.springframework.data</groupId>
            <artifactId>spring-data-jpa</artifactId>
            <version>2.4.6</version>
        </dependency>

Jpa repository instance

    @Repository
    public interface StudentRepository extends JpaRepository<Student, Long> {
    
    }
<a href="https://github.com/omeryzr/miniSchool/blob/main/src/main/java/com/miniSchool/MiniSchool/repositories/StudentRepository.java">Click to review of Student repository codes </a>

