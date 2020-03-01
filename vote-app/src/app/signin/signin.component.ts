import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent implements OnInit {

  formSign: FormGroup;

  constructor(private fbuilder: FormBuilder,
    private loginService: LoginService) { }

  ngOnInit(): void {
    this.initForm();
  }

  initForm() {
    this.formSign = this.fbuilder.group({
      username: [null, Validators.required],
      gender: [null, Validators.required],
      color: [null, Validators.required]
    });
  }

  onSubmit() {
    if (this.formSign.valid) {
      this.loginService.signIn(this.formSign.value).subscribe(res => {
        this.formSign.reset({ onlySelf : true });
      });
     
    }
  }

}
