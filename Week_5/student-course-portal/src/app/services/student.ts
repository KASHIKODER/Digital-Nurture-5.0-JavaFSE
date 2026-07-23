import { Injectable } from '@angular/core';

export interface Student {
  id: number; name: string; email: string; department: string; gpa: number; enrolledCourses: number;
}

@Injectable({ providedIn: 'root' })
export class StudentService {
  private student: Student = { id: 1, name: 'Suyash Giri', email: 'suyash@kiit.ac.in', department: 'Computer Science', gpa: 3.8, enrolledCourses: 3 };
  getStudent(): Student { return this.student; }
  updateStudent(updated: Partial<Student>): void { this.student = { ...this.student, ...updated }; }
}