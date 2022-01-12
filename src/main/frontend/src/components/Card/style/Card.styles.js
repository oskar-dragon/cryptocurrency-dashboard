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
  max-width: 400px;
  padding: 1em;
  border-radius: 8px;
  height: 250px;
`;

export const HeaderContainer = styled.div`
  display: flex;
  flex-direction: ${props => props.flexDirection};
  justify-content: space-between;
  align-items: center;
`;

export const HeaderTitle = styled.h3`
  margin: 0;
  font-size: var(--fs-subtitle);
`;

export const FiltersGroup = styled.div`
  display: flex;
`;

export const Filter = styled.a`
  padding: 0.1em 0.5em;
  margin-left: 0.5em;
  background: ${({ active }) =>
    active ? "var(--clr-accent-primary)" : "var(--clr-bg)"};
  font-weight: var(--fw-medium);

  border-radius: 5px;
  font-size: 0.75rem;
  cursor: pointer;
`;

export const Content = styled.div`
  display: flex;
  flex-direction: ${props => props.flexDirection};
  justify-content: space-between;
  align-items: center;

  height: calc(100% - 20px);
  overflow-y: auto;
`;

export const CoinWrapper = styled.div`
  width: 100%;
  display: grid;
  grid-template-columns: repeat(2, 1fr);

  justify-content: space-between;
  margin-top: 1em;
  padding-bottom: 0.7em;
  border-bottom: 1px solid lightgrey;

  ${Content} &:last-child {
    border-bottom: none;
    padding-bottom: 0;
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
  color: ${({ children: price }) =>
    price[0] > 0 ? "var(--clr-accent-secondary)" : "var(--clr-accent-primary)"};
  font-weight: var(--fw-medium);
`;
