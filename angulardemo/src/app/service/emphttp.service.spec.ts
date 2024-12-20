import { TestBed } from '@angular/core/testing';

import { EmphttpService } from './emphttp.service';

describe('EmphttpService', () => {
  let service: EmphttpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmphttpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
