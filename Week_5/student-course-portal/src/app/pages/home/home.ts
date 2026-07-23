import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { StudentService, Student } from '../../services/student';
import { CourseService } from '../../services/course';

@Component({ selector: 'app-home', standalone: true, imports: [CommonModule, RouterLink], templateUrl: './home.html', styleUrl: './home.css' })
export class HomeComponent implements OnInit {
  portalName = 'Student Course Portal';
  student!: Student;
  totalCourses = 0;
  enrolledCount = 0;
  constructor(private studentService: StudentService, private courseService: CourseService) {}
  ngOnInit(): void {
    this.student = this.studentService.getStudent();
    this.totalCourses = this.courseService.getAllCourses().length;
    this.enrolledCount = this.courseService.getEnrolledCourses().length;
  }
}