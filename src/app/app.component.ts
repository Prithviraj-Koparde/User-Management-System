import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { UserAppService } from './user-app.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'UserDashboard';
  // Define a user object for one-way binding with the Register form
  user = {
    name: '',
    password: '',
    type: ''
  };

  // Define a user object for two-way binding with the Update form ppopup
  userToUpdate = {
    id: '',
    name: '',
    password: '',
    type: ''
  };

  userDetails: any;                                           // This array will hold the user details fetched from the backend

  constructor(private userAppService: UserAppService) {
    this.getUsers();
  }

  // This method is used to register a user
  register(registerForm: NgForm) {

    // Check if the form is invalid
    if (registerForm.invalid) {
      console.error("Form is invalid; please fill out all required fields.");
      return;
    }
    // make sure that all required fields are filled
    const { name, password, type } = registerForm.value;

    if (!name || !password || !type) {
      console.error("All fields are required. Please fill in every field.");
      return;
    }

    //then
    // Log the form data to console of chrome to debug
    console.log('Form submitted:', registerForm.value);
    console.log('User data:', this.user);
    this.userAppService.insertUser(registerForm.value).subscribe(
      (resp) => {
        console.log('User registered successfully:', resp);
        registerForm.resetForm();
        this.getUsers();                                         // Call the getUsers method to fetch updated user list
      },
      (err) => {
        console.error('Error while registering user:', err);
      }
    );
  }

  // This method is used to fetch users from the backend
  getUsers() {
    this.userAppService.getUsers().subscribe(
      (resp) => {
        console.log('Users Fetched Successfully:', resp);
        this.userDetails = resp;                          // Assign the response to userDetails
      },
      (err) => {
        console.error('Error while fetching users:', err);
      }
    );
  }

  // This method is used to delete a user
  deleteUser(user: any) {
    this.userAppService.deleteUser(user.id).subscribe(
      (resp) => {
        console.log('User Deleted Successfully:', resp);
        this.getUsers();                                   // Call the getUsers method to fetch updated user list
      },
      (err) => {
        console.error('Errot while Deleting User:', err)
      }
    );
  }

  // This method is used to editing a user
  updateUser(userData: any) {
    this.userToUpdate = userData;              // Assign the user data to be updated to userToUpdate And this userToUpdate will be used in the update form popup which is called two-way binding
  }

  // This method is used to submit the update form
  // In app.component.ts
updateUserData() {
  this.userAppService.updateUser(this.userToUpdate).subscribe(
    (resp: any) => {
      console.log('User Updated Successfully:', resp);
    },
    (err: any) => {
      console.error('Error while updating user:', err);
    }
  );
}

  
}
