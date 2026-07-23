import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CourseService, Course } from '../../services/course';

@Component({ selector: 'app-course-list', standalone: true, imports: [CommonModule, FormsModule], templateUrl: './course-list.html', styleUrl: './course-list.css' })
export class CourseListComponent implements OnInit {
  courses: Course[] = [];
  filteredCourses: Course[] = [];
  searchTerm = '';
  selectedCategory = 'All';
  categories = ['All', 'Backend', 'Frontend', 'Architecture', 'DevOps'];
  constructor(private courseService: CourseService) {}
  ngOnInit(): void { this.courses = this.courseService.getAllCourses(); this.filteredCourses = this.courses; }
  filterCourses(): void { this.filteredCourses = this.courses.filter(c => { const ms = c.title.toLowerCase().includes(this.searchTerm.toLowerCase()); const mc = this.selectedCategory === 'All' || c.category === this.selectedCategory; return ms && mc; }); }
  enroll(id: number): void { this.courseService.enrollCourse(id); this.courses = this.courseService.getAllCourses(); this.filterCourses(); }
}