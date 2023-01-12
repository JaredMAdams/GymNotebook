import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { AngularMaterialModule } from './modules/angular-material.module';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './modules/app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDialogModule } from '@angular/material/dialog';
import { LoginComponent } from './components/log-in/login/login.component';
import { CookieService } from 'ngx-cookie-service';
import { MainComponent } from './components/mainview/main/main/main.component';
import { ProfileOverviewComponent } from './components/mainview/account/profile-overview/profile-overview.component';
import { ExerciseListComponent } from './components/mainview/exercises/exercise-list/exercise-list.component';
import { HomeComponent } from './components/mainview/home/home/home.component';
import { NavbarComponent } from './components/mainview/navbar/navbar.component';
import { MainDisplayComponent } from './components/mainview/workouts/workout-overview/main-display.component';
import { NewWorkoutComponent } from './components/mainview/workouts/new-workout/new-workout/new-workout.component';
import { WorkoutDisplayComponent } from './components/mainview/workouts/workout-view/workout-display.component';
import { ExerciseComponent } from './components/mainview/workouts/exercise/exercise.component';
import { SetsComponent } from './components/mainview/workouts/sets/sets.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavbarComponent,
    HomeComponent,
    ProfileOverviewComponent,
    ExerciseListComponent,
    MainDisplayComponent,
    MainComponent,
    NewWorkoutComponent,
    WorkoutDisplayComponent,
    ExerciseComponent,
    SetsComponent,
  ],
  imports: [
    BrowserModule,
    AngularMaterialModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    FormsModule,
    MatFormFieldModule,
    MatDialogModule
  ],
  providers: [CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
