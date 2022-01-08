import styled from "styled-components";
import { Link as ReactRouterLink } from "react-router-dom";

export const Container = styled.div`
  max-width: 300px;
  height: fit-content;
  background: var(--clr-light);
  border-radius: 10px;
  padding: 0 1em;
  position: relative;
`;

export const InputsWrapper = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  background: transparent;
  border: none;
  border-radius: 50px;
  padding: 0.5em 0;
`;

export const Input = styled.input`
  background: transparent;
  border: none;
  width: 90%;

  &:focus {
    outline: none;
  }
`;

export const Icon = styled.div`
  width: 10%;
  background: transparent;
  display: grid;
  place-items: center;

  & svg {
    font-size: 23px;
    color: var(--clr-semilight);
  }
`;

export const ResultsList = styled.ul`
  background: var(--clr-light);
  margin-top: 0.5em;
  max-height: 300px;
  width: 100%;
  overflow-y: auto;
  padding: 1em;
  border-radius: 5px;
  position: absolute;
  left: 0;
  right: 0;
`;

export const ResultItem = styled.li`
  padding: 0.5em 0.5em;
  cursor: pointer;
  border-radius: 5px;

  &:hover,
  &:focus {
    background: var(--clr-lightgrey);
  }
`;

export const ResultLink = styled(ReactRouterLink)`
  color: var(--clr-black);
  text-decoration: none;
  width: 100%;
  display: block;
`;
