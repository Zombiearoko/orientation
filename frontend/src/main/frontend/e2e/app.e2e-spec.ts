import { RencontrePage } from './app.po';

describe('rencontre App', () => {
  let page: RencontrePage;

  beforeEach(() => {
    page = new RencontrePage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
