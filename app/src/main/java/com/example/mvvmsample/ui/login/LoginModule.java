package com.example.mvvmsample.ui.login;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {
    @Provides
    LoginRepo provideLogInRepository() {
        return new LoginRepo();
    }

    @Provides
    LoginFactory provideLogInFactory(LoginRepo loginRepo) {
        return new LoginFactory(loginRepo);
    }

}
