import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { NewNoteComponent } from './components/new-note/new-note.component';
import { ArchiveComponent } from './components/archive/archive.component';
import { ActiveComponent } from './components/active/active.component';
import { EditNoteComponent } from './components/edit-note/edit-note.component';

const routes: Routes = [
  {path:'home',component:HomeComponent},
  {path:'archive',component:ArchiveComponent},
  {path:'active',component:ActiveComponent},
  {path:'new',component:NewNoteComponent},
  {path:'edit',component:EditNoteComponent},
  { path: '**', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
