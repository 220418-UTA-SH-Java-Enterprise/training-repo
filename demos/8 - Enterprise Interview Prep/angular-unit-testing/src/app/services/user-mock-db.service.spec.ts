import { TestBed } from '@angular/core/testing';

import { UserMockDbService } from './user-mock-db.service';

describe('UserMockDbService', () => {
  let service: UserMockDbService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserMockDbService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
