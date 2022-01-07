import { createGlobalStyle } from "styled-components";

const GlobalStyle = createGlobalStyle`
  :root {
  --ff-primary: "Roboto", sans-serif;

  --fw-light: 300;
  --fw-reg: 400;
  --fw-medium: 500;
  --fw-bold: 700;

  --clr-bg: #F1F2F6;
  --clr-secondary-bg: #0C1B2F;
  --clr-light: #fff;
  --clr-black: #0D0D0D;
  --clr-semilight: #9A9FA6;
  --clr-primary: #4A86FE;
  --clr-accent-primary: #FD6F3F;
  --clr-accent-secondary: #66A995;
  --clr-warning: #C51641;

  --fs-h1: 3rem;
  --fs-h2: 2.25rem;
  --fs-subtitle: 1.2rem;
  --fs-body: 0.875rem;
  --fs-small-text: 0.75rem

  --bs: 0.25em 0.25em 0.75em rgba(0, 0, 0, 0.25);
  }

  *,*::before, *::after {
    box-sizing: border-box;
  }

  html {
  scroll-behavior: smooth;
}

  body {
    margin: 0;
    padding: 0;
    background: var(--clr-bg);
    font-family: var(--ff-primary);
    color: var(--clr-black);
    line-height: 1.6;
    font-size: var(--fs-body)
  }

  ul {
  list-style-type: none;
  padding: 0;
  margin: 0;
}

  strong {
    font-weight: var(--fw-bold);
  }

  :focus {
  outline: 3px solid var(--clr-accent-primary);
  outline-offset: 3px;
}

::-webkit-scrollbar {
  width: 14px;
}

::-webkit-scrollbar-thumb {
  border: 4px solid rgba(0, 0, 0, 0);
  background-clip: padding-box;
  border-radius: 9999px;
  background-color: #AAAAAA;
}


`;

export default GlobalStyle;
