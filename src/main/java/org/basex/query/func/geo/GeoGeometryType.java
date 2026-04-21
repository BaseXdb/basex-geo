package org.basex.query.func.geo;

import org.basex.query.QueryContext;
import org.basex.query.QueryException;
import org.basex.query.value.item.Item;
import org.basex.query.value.item.QNm;
import org.basex.query.value.node.GNode;
import org.basex.util.InputInfo;

/**
 * Function implementation.
 *
 * @author BaseX Team, BSD License
 * @author Christian Gruen
 */
public final class GeoGeometryType extends GeoFn {
  @Override
  public Item item(final QueryContext qc, final InputInfo ii) throws QueryException {
    GNode elem = toElem(exprs[0], qc);
    return new QNm(GML, toGeometry(elem).getGeometryType(), elem.qname().uri());
  }
}
