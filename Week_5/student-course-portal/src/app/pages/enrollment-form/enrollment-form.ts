import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CourseService, Course } from '../../services/course';

@Component({ selector: 'app-enrollment-form', standalone: true, imports: [CommonModule, ReactiveFormsModule], templateUrl: './enrollment-form.html', styleUrl: './enrollment-form.css' })
export class EnrollmentFormComponent implements OnInit {
  enrollForm!: FormGroup;
  courses: Course[] = [];
  submitted = false;
  successMessage = '';
  constructor(private fb: FormBuilder, private courseService: CourseService) {}
  ngOnInit(): void {
    this.courses = this.courseService.getAllCourses().filter(c => !c.enrolled);
    this.enrollForm = this.fb.group({ studentName: ['', [Validators.required, Validators.minLength(3)]], email: ['', [Validators.required, Validators.email]], courseId: ['', Validators.required], reason: ['', [Validators.required, Validators.minLength(10)]] });
  }
  get f() { return this.enrollForm.controls; }
  onSubmit(): void { this.submitted = true; if (this.enrollForm.invalid) return; this.courseService.enrollCourse(Number(this.enrollForm.value.courseId)); this.successMessage = 'Successfully enrolled in course!'; this.enrollForm.reset(); this.submitted = false; this.courses = this.courseService.getAllCourses().filter(c => !c.enrolled); }
}