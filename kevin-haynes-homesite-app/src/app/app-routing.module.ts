import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ResumeComponent } from "./resume/resume.component";
import {WorkOverviewComponent} from "./work-overview/work-overview.component";
import {AboutComponent} from "./about/about.component";
import {HomeComponent} from "./home/home.component";
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";

const routes: Routes = [
  { path: 'resume-component', component: ResumeComponent },
  { path: 'work-overview-component', component: WorkOverviewComponent },
  { path: 'about-component', component: AboutComponent },
  { path: 'home-component', component: HomeComponent },
  { path: '', component: HomeComponent },
  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
