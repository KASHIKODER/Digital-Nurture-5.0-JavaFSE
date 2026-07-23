import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { StudentService, Student } from '../../services/student';
import { CourseService, Course } from '../../services/course';

@Component({ selector: 'app-student-profile', standalone: true, imports: [CommonModule, FormsModule], templateUrl: './student-profile.html', styleUrl: './student-profile.css' })
export class StudentProfileComponent implements OnInit {
  student!: Student;
  enrolledCourses: Course[] = [];
  isEditing = false;
  editName = '';
  constructor(private studentService: StudentService, private courseService: CourseService) {}
  ngOnInit(): void { this.student = this.studentService.getStudent(); this.enrolledCourses = this.courseService.getEnrolledCourses(); }
  toggleEdit(): void { this.isEditing = !this.isEditing; this.editName = this.student.name; }
  saveProfile(): void { this.studentService.updateStudent({ name: this.editName }); this.student = this.studentService.getStudent(); this.isEditing = false; }
}