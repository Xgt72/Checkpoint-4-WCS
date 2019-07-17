import { TestBed } from '@angular/core/testing';

import { LineCartService } from './line-cart.service';

describe('LineCartService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LineCartService = TestBed.get(LineCartService);
    expect(service).toBeTruthy();
  });
});
