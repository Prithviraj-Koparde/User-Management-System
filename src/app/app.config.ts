import { provideRouter } from '@angular/router';
import { importProvidersFrom } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';

export const appConfig = {
  providers: [
    provideRouter([]),
    importProvidersFrom(FormsModule),
    provideHttpClient(withInterceptorsFromDi())
  ]
};
