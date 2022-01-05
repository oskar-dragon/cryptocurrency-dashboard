import styled from "styled-components";
import { Link as ReachRouterLink } from "react-router-dom";

export const Container = styled.div`
  background: var(--clr-secondary-bg);
  display: flex;
  flex-direction: column;
  padding: 1.5em;
  width: 250px;
  height: 100%;
  position: fixed;
`;

export const Logo = styled.p`
  color: var(--clr-light);
  font-weight: var(--fw-bold);
  margin-top: 0;
  margin-left: 0.7em;
  letter-spacing: 0.5px;
  font-size: 1.2rem;
`;

export const Group = styled.nav`
  display: flex;
  flex-direction: column;
`;

export const Link = styled(ReachRouterLink)`
  background: var(--clr-secondary-bg);
  color: var(--clr-semilight);
  font-weight: var(--fw-medium);
  text-decoration: none;
  padding: 0.4em 0.9em;
  margin-bottom: 0.6em;
  border-radius: 5px;
  ${props => props.active && "filter: brightness(170%) saturate(40%);"}

  &:focus,
  &:hover {
    filter: brightness(170%) saturate(40%);
    box-shadow: rgba(0, 0, 0, 0.16) 0px 3px 6px, rgba(0, 0, 0, 0.23) 0px 3px 6px;
  }
`;
