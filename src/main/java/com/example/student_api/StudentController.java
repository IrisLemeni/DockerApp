package com.example.student_api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String showWelcomePage() {
        return "index"; // Pagina principală
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent"; // Formularul de adăugare student
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.addStudent(student);
        return "redirect:/students"; // După adăugare, redirecționează la pagina principală
    }

    // Pagina de vizualizare student
    @GetMapping("/view")
    public String showViewForm() {
        return "viewStudentForm"; // Formularul de căutare student
    }

    // Căutarea unui student după ID
    @PostMapping("/view")
    public String viewStudent(@RequestParam Long id, Model model) {
        Optional<Student> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            model.addAttribute("student", student.get());
            return "viewStudent"; // Pagina de vizualizare a studentului
        } else {
            model.addAttribute("error", "Student not found");
            return "viewStudentForm"; // Dacă nu este găsit, arată un mesaj de eroare
        }
    }

    @GetMapping("/update")
    public String showUpdateForm() {
        return "updateStudentForm"; // Formularul de actualizare student
    }

    @PostMapping("/update")
    public String updateStudent(@RequestParam Long id, @ModelAttribute Student student) {
        studentService.updateStudent(id, student);
        return "redirect:/students"; // După actualizare, redirecționează la pagina principală
    }

    @GetMapping("/delete")
    public String showDeleteForm() {
        return "deleteStudentForm"; // Formularul de ștergere student
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students"; // După ștergere, redirecționează la pagina principală
    }
}
