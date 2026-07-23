import { Injectable } from '@angular/core';

export interface Course {
  id: number;
  title: string;
  instructor: string;
  credits: number;
  category: string;
  enrolled: boolean;
}

@Injectable({ providedIn: 'root' })
export class CourseService {
  private courses: Course[] = [
    { id: 1, title: 'Java Full Stack', instructor: 'Dr. Sharma', credits: 4, category: 'Backend', enrolled: true },
    { id: 2, title: 'Angular Framework', instructor: 'Prof. Gupta', credits: 3, category: 'Frontend', enrolled: true },
    { id: 3, title: 'Spring Boot REST', instructor: 'Dr. Kumar', credits: 4, category: 'Backend', enrolled: false },
    { id: 4, title: 'Microservices', instructor: 'Prof. Singh', credits: 3, category: 'Architecture', enrolled: false },
    { id: 5, title: 'DevOps and Docker', instructor: 'Dr. Patel', credits: 2, category: 'DevOps', enrolled: false }
  ];
  getAllCourses(): Course[] { return this.courses; }
  getEnrolledCourses(): Course[] { return this.courses.filter(c => c.enrolled); }
  enrollCourse(id: number): void { const c = this.courses.find(c => c.id === id); if (c) c.enrolled = true; }
  getCourseById(id: number): Course | undefined { return this.courses.find(c => c.id === id); }
}