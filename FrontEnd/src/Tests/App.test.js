import {render, screen} from '@testing-library/react';
import App from '../App';

test('Renders starting point + checking if the div with the browserRouter is presented in the document', () => {
  const result = render(<App />);
  const linkElement = result.container.querySelector(".App");
  expect(linkElement).toBeInTheDocument();
});
