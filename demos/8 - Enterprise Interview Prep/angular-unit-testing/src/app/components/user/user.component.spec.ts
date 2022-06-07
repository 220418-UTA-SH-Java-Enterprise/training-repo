import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { UserMockDbService } from 'src/app/services/user-mock-db.service';
import { UserService } from 'src/app/services/user.service';

import { UserComponent } from './user.component';

describe('UserComponent', () => {
  let component: UserComponent;
  let fixture: ComponentFixture<UserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserComponent ],
      //providers dictate how services are injected to accomplish what they are designed to do
      providers: [{provide: UserService, useClass: UserMockDbService}]
    })
    /*
      here we can telling Jasmine to compile our component within the fixture while injecting our mocks into this component
    */
   /*
    Service vs Provider
    - A service is an object that exist within your application.
    - A provider is the WAY you gain access to that object
   */
    .compileComponents().then(() => {
      fixture = TestBed.createComponent(UserComponent);
      component = fixture.componentInstance;
    });
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  //test will check if the service provides ONE user in the array
  it('should be one user', waitForAsync(() => {
    expect(component.users.length).toEqual(1); //why? because the users component in this test environment retrieves only 1 user object from the mock service
  }));

  //test should render 1 user to the page
  it('html should render one user', waitForAsync(() => {
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;

    expect(compiled.querySelector('p')?.innerText).toContain('user1');
  }))
});
