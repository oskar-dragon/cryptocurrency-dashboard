import styled from "styled-components";

export const Group = styled.div`
  display: flex;
  justify-content: space-between;
  width: 80%;
  max-width: 1000px;
`;

export const Container = styled.div`
  background: var(--clr-light);
  width: 100%;
  max-width: 350px;
  height: 260px;
  padding: 1em;
  border-radius: 8px;
  overflow: auto;
`;

export const Content = styled.div`
  display: flex;
  flex-direction: ${props => props.flexDirection};
  justify-content: space-between;
  align-items: center;
  overflow: scroll;
`; // For wrapping content inside of cards

export const Header = styled.h3`
  margin: 0;
  font-size: var(--fs-subtitle);
`;

export const FiltersGroup = styled.ul`
  display: flex;
`;

export const Filter = styled.li`
  padding: 0.1em 0.5em;
  margin-left: 0.5em;
  background: ${({ active }) =>
    active ? "var(--clr-accent-primary)" : "var(--clr-bg)"};
  font-weight: var(--fw-medium);

  border-radius: 5px;
  font-size: 0.75rem;
  cursor: pointer;
`;

export const CoinWrapper = styled.div`
  width: 100%;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 0.5em 1em;
  justify-content: space-between;
  margin-top: 1em;
  padding-bottom: 0.7em;
  border-bottom: 1px solid lightgrey;
`;

export const CoinTitle = styled.h4`
  margin: 0;
`;

export const MarketCap = styled.p`
  margin: 0;
  color: var(--clr-semilight);
  font-weight: var(--fw-medium);
`;

export const Price = styled.p`
  margin: 0;
  text-align: right;
  font-weight: var(--fw-medium);
`;

export const PriceChange = styled.p`
  margin: 0;
  text-align: right;
  color: var(--clr-accent-secondary);
  font-weight: var(--fw-medium);
`;
