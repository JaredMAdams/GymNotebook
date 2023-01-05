import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from '../components/log-in/login/login.component';
import { ProfileOverviewComponent } from '../components/mainview/account/profile-overview/profile-overview.component';
import { ExerciseListComponent } from '../components/mainview/exercises/exercise-list/exercise-list.component';
import { HomeComponent } from '../components/mainview/home/home/home.component';
import { MainComponent } from '../components/mainview/main/main/main.component';
import { AuthGuard } from '../guards/auth.guard';
import { MainDisplayComponent } from '../components/mainview/workouts/workout-overview/main-display.component';



const routes: Routes = [
  { path: '', redirectTo: 'main', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'main', component: MainComponent, canActivate: [AuthGuard], children: [
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: 'workout', component: MainDisplayComponent },
    { path: 'exercises', component: ExerciseListComponent },
    { path: 'account', component: ProfileOverviewComponent }
  ] },
]

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
