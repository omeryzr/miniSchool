~~Back-end~~ / Java, Spring Boot, RestAPI, UnitTest, Spring Security, PostgreSQL, NoSQL, Maven~Tomcat

~~Front-End~~ / JavaScript, ReactJS, Redux

~~Deploying~~ / AWS, Docker, Kubernetes


#### Review to Models

Student - Instructor - Lesson 
    
###### 1 - Student ~ With Standard technique 
    
        `Description for Annotations 
            @Entity 
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column('student_id')`

<a href="https://github.com/omeryzr/miniSchool/blob/main/src/main/java/com/miniSchool/MiniSchool/models/Student.java">Click to review of Student model codes </a>
     
###### 2 - Instructor ~ Create with Lombok
    
      add in the file of pom.xml
      
      `<dependencies>
          ...
          <dependency>
              <groupId>org.projectlombok</groupId>
              <artifactId>lombok</artifactId>
              <version>1.18.10</version>
              <scope>provided</scope>
          </dependency>
          ...
      </dependencies>`

After added dependency
       
   @Getter
   @Setter
   @NoArgsConstructor
       
<a href="https://github.com/omeryzr/miniSchool/blob/main/src/main/java/com/miniSchool/MiniSchool/models/Instructor.java">Click to review of Instructor model codes </a>



###### Review to Repository

add Jpa dependency in pom.xml

    `<dependency>
        <groupId>org.springframework.data</groupId>
        <artifactId>spring-data-jpa</artifactId>
        <version>2.4.6</version>
    </dependency>`

Jpa repository instance

    `@Repository
    public interface StudentRepository extends JpaRepository<Student, Long> {
    
    }`
<a href="https://github.com/omeryzr/miniSchool/blob/main/src/main/java/com/miniSchool/MiniSchool/repositories/StudentRepository.java">Click to review of Student repository codes </a>



###### Configure and Connect PostgreSQL

add dependency in the pom.xml

    `<dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
    </dependency> `
    
add configure command in the application.properties

    spring.datasource.url= jdbc:postgresql://localhost:5432/minischool?useSSL=false
    
    spring.datasource.username=username //fill up your username     
    spring.datasource.password=password //fill up your password
    # The SQL dialect makes Hibernate generate better SQL for the chosen database
    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
    
    # Disable feature detection by this undocumented parameter. Check the org.hibernate.engine.jdbc.internal.JdbcServiceImpl.configure method for more details.
    spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults = false
    
    # Because detection is disabled you have to set correct dialect by hand.
    spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL9Dialect
    
    
    spring.jpa.show-sql=true
    spring.jpa.hibernate.ddl-auto=update


<a href="https://github.com/omeryzr/miniSchool/blob/main/src/main/resources/application.properties">you can review the application.properties file </a>

What we did so far;
    
   - we created Instructor, Student and Lecture models (tables)
   - we created Instructor, Student and Lecture repositories (JPA extension)
   - we connected named of minischool postgresql database with application
    
    

###### Review Controller and Paths
    
    I will show a basic code lines about controller path
    
    `@RestController
     @RequestMapping("/api/v1/students")
    public class StudentController {
    
        @Autowired
        private StudentRepository studentRepository;
    
        @GetMapping
        public List<Student> students(){
            return studentRepository.findAll();
        }
    }`
    
    as you can see above, we created a modul to find all students
    
    
    I will show you two kind filter request
    
    1 - /filter?grade=3 
        `@GetMapping("/filter")
        @ResponseBody
        public List<Student> studentByGrade(@RequestParam int grade){
            return studentRepository.findByStudentGrade(grade);
        }`
    
    2 - /id
    we will create this module with @RequestMapping and @PathVariable annotations
        `@GetMapping
        @RequestMapping("{id}")
        public Student showStudentWithId(@PathVariable Long id){
            return studentRepository.getOne(id);
        } `

@ManyToMany relationship between Lecture and Students

       @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
       @JoinTable(
               name = "lecture_like",
               joinColumns = @JoinColumn(name = "student_id"),
               inverseJoinColumns = @JoinColumn(name = "lecture_id")
       )
       private List<Lecture> lectures;
  >>Student table    
       
       
       
       @JsonIgnore
           @ManyToMany(fetch = FetchType.LAZY,mappedBy  = "lectures")
           private List<Student> students;
  >>Lecture table

         
  we can avoid infinite loop rows with this command
        
        (cascade = CascadeType.ALL, fetch=FetchType.EAGER)   


###ResponseEntity

ResponseEntity represents the whole HTTP response: status code, headers, and body.

    @GetMapping("/hello")
    ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    } 