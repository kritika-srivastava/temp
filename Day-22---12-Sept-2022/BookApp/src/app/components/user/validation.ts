import { AbstractControl, ValidatorFn } from "@angular/forms";

export class Validation {
    static match(password: string, confirmpassword: string): ValidatorFn {
        return (ctrl: AbstractControl) => {
            const pwd = ctrl.get(password);
            const cpwd = ctrl.get(confirmpassword);

            if (pwd?.value !== cpwd?.value) {
                ctrl.get(confirmpassword)?.setErrors({ matching: true });
                return { matching: true };
            }
            else {
                return null;
            }
        }

    }
}